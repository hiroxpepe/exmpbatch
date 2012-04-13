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

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

import org.examproject.batch.dto.ContentDto;

/**
 * the simple service class.
 * @author hiroxpepe
 */
public class SimpleContentService implements ContentService {

    private static final Log LOG = LogFactory.getLog(
        SimpleContentService.class
    );

    @Inject
    private final ApplicationContext context = null;

    private List<ContentDto> dtoList = new CopyOnWriteArrayList<ContentDto>();

    @Override
    public void load() {
        LOG.debug("called.");
        try {
            // TODO:
            
            // dummy content objects.
            ContentDto dto1 = context.getBean(ContentDto.class);
            dto1.setId(new Long(1));
            dto1.setName("hoge");
            dtoList.add(dto1);
            
            ContentDto dto2 = context.getBean(ContentDto.class);
            dto2.setId(new Long(2));
            dto2.setName("piyo");
            dtoList.add(dto2);
            
            ContentDto dto3 = context.getBean(ContentDto.class);
            dto3.setId(new Long(3));
            dto3.setName("fuga");
            dtoList.add(dto3);
            
        } catch (Exception e) {
            LOG.error("Exception occurred. " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save() {
        LOG.debug("called.");
        try {
            // TODO:
            // save to repository.
            
        } catch (Exception e) {
            LOG.error("Exception occurred. " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void receive(ContentDto dto) {
        // TODO:
        LOG.debug(
            "receive -- id: " + dto.getId() +
            " name: " + dto.getName()
        );
    }

    @Override
    public List<ContentDto> getList(){
        return dtoList;
    }

}
