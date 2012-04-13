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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.ChunkListener;

/**
 * @author hiroxpepe
 */
public final class ContentChunkListener implements ChunkListener {

    private static final Log LOG = LogFactory.getLog(
        ContentChunkListener.class
    );

    @Override
    public void beforeChunk() {
        LOG.info(">>>>>>>> beforeChunk called.");
        try {
            // TODO:
        } catch (Exception e) {
            LOG.error("error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void afterChunk() {
        LOG.info("<<<<<<<<< afterChunk called.");
        try {
            // TODO:
        } catch (Exception e) {
            LOG.error("error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
