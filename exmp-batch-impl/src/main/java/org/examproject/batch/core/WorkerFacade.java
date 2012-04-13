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

package org.examproject.batch.core;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

import org.apache.commons.lang.time.StopWatch;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;

/**
 * @author hiroxpepe
 */
public class WorkerFacade {

    private static final Log LOG = LogFactory.getLog(
        WorkerFacade.class
    );

    @Inject
    private final JobLauncher jobLauncher = null;

    @Inject
    private final Job job = null;
    
    public void work() {
        LOG.debug("called.");
        try {
            LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> run a job begin.");

            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            
            // create the jobparameter.
            JobParameter parameter = new JobParameter(
                new Date()
            );
            
            Map<String, JobParameter> map = new HashMap<String, JobParameter>();
            map.put(
                "date",
                parameter
            );
            
            // run the job.
            jobLauncher.run(
                job,
                new JobParameters(
                    map
                )
            );

            stopWatch.stop();
            LOG.info("execute time: " + stopWatch.getTime() + " msec");
            
            LOG.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< run a job end.");
            
        } catch (Exception e) {
            LOG.fatal("fatal: " + e.getMessage());
        }
    }
}
