// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package qa.free.tools.selenium.toolkit.utilities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import qa.free.tools.selenium.toolkit.annotations.FindElement;
import qa.free.tools.selenium.toolkit.core.page.object.PageObject;
import qa.free.tools.selenium.toolkit.exceptions.ElementNotSpecifiedException;
import qa.free.tools.selenium.toolkit.utilities.mock.DummyPageObjectClassWithNoFindElements;

/**
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
class ThreadHelperTest {

	@Test
	void findMethodWithAnnotation_shouldRaiseAnExceptionIfAnnotationOnMethodIsMissing() {
		PageObject<DummyPageObjectClassWithNoFindElements> pageObject = new DummyPageObjectClassWithNoFindElements();
		ElementNotSpecifiedException thrown = Assertions.assertThrows(ElementNotSpecifiedException.class, () -> {
			ThreadHelper.findMethodWithAnnotation(pageObject, FindElement.class);
		});
		Assertions.assertEquals("Element(s) not specified using @FindElement annotation. Make sure page object is public", 
				thrown.getMessage());
	}
	
}
