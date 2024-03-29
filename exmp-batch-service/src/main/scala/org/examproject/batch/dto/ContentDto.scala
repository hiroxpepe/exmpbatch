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

package org.examproject.batch.dto

import java.lang.Long

import scala.reflect.BeanProperty

import java.lang.Boolean
import java.lang.Long
import java.util.Date

/**
 * @author hiroxpepe
 */
trait ContentDto {

    @BeanProperty
    var id: Long = _
    
    @BeanProperty
    var name: String = _
    
    @BeanProperty
    var created: Date = _
    
    @BeanProperty
    var completed: Date = _

    @BeanProperty
    var isError: Boolean = false
    
    @BeanProperty
    var isComplete: Boolean = false
    
}
