/* Copyright 2004, 2005 Acegi Technology Pty Limited
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

package net.sf.acegisecurity;

import net.sf.acegisecurity.providers.anonymous.AnonymousAuthenticationToken;


/**
 * Basic implementation of {@link AuthenticationTrustResolverImpl}.
 * 
 * <P>
 * Makes trust decisions based on whether the passed
 * <code>Authentication</code> is an instance of a defined class.
 * </p>
 * 
 * <p>
 * If {@link #anonymousClass} or {@link #rememberMeClass} is <code>null</code>,
 * the corresponding method will always return <code>false</code>.
 * </p>
 *
 * @author Ben Alex
 * @version $Id$
 */
public class AuthenticationTrustResolverImpl
    implements AuthenticationTrustResolver {
    //~ Instance fields ========================================================

    private Class anonymousClass = AnonymousAuthenticationToken.class;
    private Class rememberMeClass;

    //~ Methods ================================================================

    public boolean isAnonymous(Authentication authentication) {
        if ((anonymousClass == null) || (authentication == null)) {
            return false;
        }

        return anonymousClass.isAssignableFrom(authentication.getClass());
    }

    public void setAnonymousClass(Class anonymousClass) {
        this.anonymousClass = anonymousClass;
    }

    public Class getAnonymousClass() {
        return anonymousClass;
    }

    public boolean isRememberMe(Authentication authentication) {
        if ((rememberMeClass == null) || (authentication == null)) {
            return false;
        }

        return rememberMeClass.isAssignableFrom(authentication.getClass());
    }

    public void setRememberMeClass(Class rememberMeClass) {
        this.rememberMeClass = rememberMeClass;
    }

    public Class getRememberMeClass() {
        return rememberMeClass;
    }
}
