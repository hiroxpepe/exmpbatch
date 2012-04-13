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

package org.examproject.batch.processor;

import java.util.Hashtable;
import java.util.Map;
import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.batch.item.ItemProcessor;

import org.examproject.batch.dto.ContentDto;

/**
 * @author hiroxpepe
 */
public class ContentItemProcessor implements ItemProcessor {

    private static final Log LOG = LogFactory.getLog(
        ContentItemProcessor.class
    );

    @Inject
    private final ApplicationContext context = null;

    @Override
    public ContentDto process(Object item) throws Exception {
        LOG.debug("called.");

        ContentDto dto = (ContentDto) item;

        try {            
            // TODO:
            LOG.debug(
                "process -- id: " + dto.getId() +
                " name: " + dto.getName()
            );
            
            // dummy wait..
            Thread.sleep(1000);

            return dto;

        } catch (Exception e) {
            LOG.error("error: " + e.getMessage());
            
            // must return the dto.
            return dto;
        }
    }

}
