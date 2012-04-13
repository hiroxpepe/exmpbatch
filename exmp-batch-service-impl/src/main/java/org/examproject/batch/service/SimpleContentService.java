/* 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.examproject.batch.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dozer.Mapper;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import org.examproject.batch.entity.Content;
import org.examproject.batch.dto.ContentDto;
import org.examproject.batch.repository.ContentRepository;

/**
 * simple service class.
 * @author hiroxpepe
 */
public class SimpleContentService implements ContentService {

    private static final Log LOG = LogFactory.getLog(
        SimpleContentService.class
    );

    @Inject
    private final ApplicationContext context = null;
    
    @Inject
    private final Mapper mapper = null;
    
    @Inject
    private final ContentRepository contentRepository = null;

    private List<Content> entityList = new CopyOnWriteArrayList<Content>();
    
    private List<ContentDto> dtoList = new CopyOnWriteArrayList<ContentDto>();
    
    private List<ContentDto> returnedDtoList = new CopyOnWriteArrayList<ContentDto>();

    ///////////////////////////////////////////////////////////////////////////
    // public methods
    
    @Override
    @Transactional
    public void load() {
        LOG.debug("called.");
        try {            
            // initialize.
            clearList();
            
            // get the entity list.
            entityList = contentRepository.findNotCompleted();
            
            // map the entity to dto.
            for (Content entity: entityList) {
                
                // create the dto.
                ContentDto dto = context.getBean(
                    ContentDto.class
                );
                
                // map the entity to dto.
                mapper.map(
                    entity,
                    dto
                );
                
//                // set the date.
//                dto.setCreated(
//                    new Date()
//                );
                
                // add to the dto list.
                dtoList.add(
                    dto
                );
            }
            
        } catch (Exception e) {
            LOG.error("Exception occurred. " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public void save() {
        LOG.debug("called.");
        try {
            // save to repository.
            for (ContentDto dto : returnedDtoList) {
                
                // if the dto has an error it will be skipped.
                if (dto.getIsError()) {
                    continue;
                }
                
                // find the entity.
                Content entiry = contentRepository.findById(
                    dto.getId()
                );
                
                // map the dto to entity.
                mapper.map(
                    dto,
                    entiry
                );
                
                // save the entity.
                contentRepository.save(
                    entiry
                );
            }
            
        } catch (Exception e) {
            LOG.error("Exception occurred. " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public void receive(ContentDto dto) {
        LOG.debug("called.");
        
        // add to the returned list.
        returnedDtoList.add(
            dto
        );
    }

    @Override
    @Transactional
    public List<ContentDto> getList(){
        LOG.debug("called.");
        
        // return the dto list.
        return dtoList;
    }

    ///////////////////////////////////////////////////////////////////////////
    // private methods
    
    private void clearList() {
        entityList.clear();
        dtoList.clear();
        returnedDtoList.clear();
    }
    
}
