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

package org.examproject.batch.reader;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.ParseException;

import org.examproject.batch.dto.ContentDto;
import org.examproject.batch.service.ContentService;

/**
 * @author hiroxpepe
 */
public class ContentItemReader implements ItemReader<ContentDto>{

    private static final Log LOG = LogFactory.getLog(
        ContentItemReader.class
    );

    @Inject
    private final ContentService contentService = null;

    @Override
    public ContentDto read() throws Exception, UnexpectedInputException, ParseException {
        LOG.debug("called.");

        // until list is null.
        if (! contentService.getList().isEmpty()) {
            
            // TODO :
            ContentDto dto = 
                (ContentDto) contentService.getList().remove(0);
            
            LOG.debug(
                "read -- id: " + dto.getId() +
                " name: " + dto.getName()
            );

            return dto;
        }
        
        LOG.debug("content list is already null.");
        return null;
    }
}
