/*
 * Copyright 2006-2008 Web Cohesion
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codehaus.enunciate.contract.jaxrs;

import com.sun.mirror.declaration.MethodDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;
import com.sun.mirror.type.DeclaredType;
import com.sun.mirror.type.TypeMirror;
import net.sf.jelly.apt.Context;
import net.sf.jelly.apt.decorations.declaration.DecoratedMethodDeclaration;

import javax.ws.rs.Path;

/**
 * A sub-resource locator.  Invoked on a JAX-RS resource in order to locate a subresource.
 *
 * @author Ryan Heaton
 */
public class SubResourceLocator extends DecoratedMethodDeclaration {

  private final Path path;
  private final SubResource resource;
  private final Resource parent;

  public SubResourceLocator(MethodDeclaration methodDeclaration, Resource parent) {
    super(methodDeclaration);
    this.parent = parent;

    this.path = methodDeclaration.getAnnotation(Path.class);
    if (this.path == null) {
      throw new IllegalArgumentException("A subresource locator must specify a path with the @javax.ws.rs.Path annotation.");
    }

    SubResource resource;
    TypeMirror returnType = methodDeclaration.getReturnType();
    if ((returnType instanceof DeclaredType) && ((DeclaredType) returnType).getDeclaration() != null) {
      TypeDeclaration declaration = ((DeclaredType) returnType).getDeclaration();
      resource = new SubResource(declaration, getPath(), parent);
    }
    else {
      resource = new SubResource(Context.getCurrentEnvironment().getTypeDeclaration(Object.class.getName()), getPath(), parent);
    }
    this.resource = resource;
  }

  /**
   * The path of the subresource.
   *
   * @return The path of the subresource.
   */
  public String getPath() {
    return this.path.value();
  }

  /**
   * The resource that this locates.
   *
   * @return The resource that this locates.
   */
  public SubResource getResource() {
    return resource;
  }

  /**
   * The resource that hosts this locator.
   *
   * @return The resource that hosts this locator.
   */
  public Resource getParent() {
    return parent;
  }
}
