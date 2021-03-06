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

package com.webcohesion.enunciate.modules.idl;

import java.io.File;

/**
 * The object used to configure the generation of a schema, overrides the defaults.
 *
 * @author Ryan Heaton
 */
public class WsdlConfig {

  private String namespace;
  private File useFile;
  private String filename;
  private boolean inlineSchema = true;

  /**
   * The target namespace.
   *
   * @return The target namespace.
   */
  public String getNamespace() {
    return namespace;
  }

  /**
   * The target namespace.
   *
   * @param namespace The target namespace.
   */
  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  /**
   * The (already existing) file to use for this wsdl.
   *
   * @return The (already existing) file to use for this wsdl.
   */
  public File getUseFile() {
    return useFile;
  }

  /**
   * The (already existing) file to use for this wsdl.
   *
   * @param useFile The (already existing) file to use for this wsdl.
   */
  public void setUseFile(File useFile) {
    this.useFile = useFile;
  }

  /**
   * The file to which to write this schema.
   *
   * @return The file to which to write this schema.
   */
  public String getFilename() {
    return filename;
  }

  /**
   * The file to which to write this schema.
   *
   * @param filename The file to which to write this schema.
   */
  public void setFilename(String filename) {
    this.filename = filename;
  }

  /**
   * Whether to inline the schema for this WSDL.
   *
   * @return Whether to inline the schema for this WSDL.
   */
  public boolean isInlineSchema() {
    return inlineSchema;
  }

  /**
   * Whether to inline the schema for this WSDL.
   *
   * @param inlineSchema Whether to inline the schema for this WSDL.
   */
  public void setInlineSchema(boolean inlineSchema) {
    this.inlineSchema = inlineSchema;
  }
}
