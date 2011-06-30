/*
 * Copyright 2003-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codehaus.groovy.tools.stubgenerator

/**
 * Test that FQN appears in generated stub when an annotation node
 *  is used as an annotation member value.
 *
 * @author Paul King
 */
class PropertyWithCustomSetterHavingReturnTypeStubTest extends StringSourcesStubTestCase {

    Map<String, String> provideSources() {
        [
                'Dummy.java': '''
                    public class Dummy {}
                ''',
                'foo/SetterWithReturn4646.groovy': '''
                    package foo;

                    class SetterWithReturn4646 {
                        String foo
                        SetterWithReturn4646 setFoo(String foo) { this.foo = foo; return this; }
                    }
            '''
        ]
    }

    void verifyStubs() {
        assert !stubJavaSourceFor('foo.SetterWithReturn4646').contains('void setFoo(java.lang.String ')
    }
}