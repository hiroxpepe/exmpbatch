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

package org.examproject.batch.repository

import java.lang.Long
import java.util.List

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

import org.examproject.batch.entity.Content

/**
 * @author hiroxpepe
 */
trait ContentRepository extends JpaRepository[Content, Long] {
    
    def findById(id: Long): Content
    
    @Query("select c from Content c where c.isComplete = false")
    def findNotCompleted(): List[Content]
}
