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

package org.examproject.batch.writer;

import java.util.Date;
import java.util.List;
import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;

import org.examproject.batch.dto.ContentDto;
import org.examproject.batch.service.ContentService;

/**
 * @author hiroxpepe
 */
public class ContentItemWriter implements ItemWriter<ContentDto> {

    private static final Log LOG = LogFactory.getLog(
        ContentItemWriter.class
    );

    @Inject
    private final ContentService contentService = null;

    @Override
    public void write(List<? extends ContentDto> items) throws Exception {
        LOG.debug("called.");

        for (ContentDto dto : items) {
            try {
                // TODO:
                LOG.debug(
                    "write -- id: " + dto.getId() +
                    " name: " + dto.getName()
                );
                
                ///////////////////////////////////////////
                // if this is the final write module.
                
                // set the completed flag.
                dto.setIsComplete(true);
                dto.setCompleted(
                    new Date()
                );
                
                // receive the dto.
                // most important.
                contentService.receive(
                    dto
                );
                
                LOG.debug(
                    "receive -- id: " + dto.getId() +
                    " name: " + dto.getName()
                );
                
            } catch (Exception e) {
                LOG.error("error: " + e.getMessage());
                
                // set the error flag to the dto.
                dto.setIsError(true);
            }
        }
    }
}
