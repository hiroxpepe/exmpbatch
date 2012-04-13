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

package org.examproject.batch.listener;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.StepExecutionListener ;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.ExitStatus;

import org.examproject.batch.service.ContentService;

/**
 * @author hiroxpepe
 */
public class ContentStepListener implements StepExecutionListener  {

   private static final Log LOG = LogFactory.getLog(
       ContentStepListener.class
   );
   
   @Inject
   private final ContentService contentService = null;

   @Override
   public void beforeStep(StepExecution stepExecution) {
        LOG.info(">>>>>>>>>>>>>>>>>>>>>>>> beforeStep called.");
        try {
            contentService.load();
        } catch (Exception e) {
            LOG.error("error: " + e.getMessage());
            throw new RuntimeException(e);
        }
   }
   
   @Override
   public ExitStatus afterStep(StepExecution stepExecution) {
       LOG.info("<<<<<<<<<<<<<<<<<<<<<<<<<< afterStep called.");
       try {
           contentService.save();
        } catch (Exception e) {
            LOG.error("error: " + e.getMessage());
            throw new RuntimeException(e);
        }
        LOG.info("============ ExitStatus.COMPLETED returned.");
        return ExitStatus.COMPLETED;
   }
}
