/*
 * JBoss, Home of Professional Open Source
 * Copyright 2008, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.webbeans.introspector;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;

/**
 * Provides an abstraction for delegating access to an annotated item
 * 
 * @author Pete Muir
 * 
 * @param <T>
 * @param <S>
 */
public abstract class ForwardingAnnotatedItem<T, S> implements AnnotatedItem<T, S>
{

   /**
    * @see org.jboss.webbeans.introspector.AnnotatedItem
    */
   public Type[] getActualTypeArguments()
   {
      return delegate().getActualTypeArguments();
   }

   /**
    * @see org.jboss.webbeans.introspector.AnnotatedItem
    */
   public <A extends Annotation> A getAnnotation(Class<? extends A> annotationType)
   {
      return delegate().getAnnotation(annotationType);
   }

   /**
    * @see org.jboss.webbeans.introspector.AnnotatedItem
    */
   public <A extends Annotation> Set<A> getAnnotations()
   {
      return delegate().getAnnotations();
   }

   /**
    * @see org.jboss.webbeans.introspector.AnnotatedItem
    */
   public Set<Annotation> getMetaAnnotations(Class<? extends Annotation> metaAnnotationType)
   {
      return delegate().getMetaAnnotations(metaAnnotationType);
   }

   /**
    * @see org.jboss.webbeans.introspector.AnnotatedItem
    */
   public Annotation[] getMetaAnnotationsAsArray(Class<? extends Annotation> metaAnnotationType)
   {
      return delegate().getMetaAnnotationsAsArray(metaAnnotationType);
   }

   /**
    * @see org.jboss.webbeans.introspector.AnnotatedItem
    */
   public Set<Annotation> getBindingTypes()
   {
      return delegate().getBindingTypes();
   }

   /**
    * @see org.jboss.webbeans.introspector.AnnotatedItem
    */
   public Annotation[] getBindingTypesAsArray()
   {
      return delegate().getBindingTypesAsArray();
   }

   /**
    * @see org.jboss.webbeans.introspector.AnnotatedItem
    */
   public String getName()
   {
      return delegate().getName();
   }

   /**
    * @see org.jboss.webbeans.introspector.AnnotatedItem
    */
   public Class<T> getType()
   {
      return delegate().getType();
   }

   /**
    * @see org.jboss.webbeans.introspector.AnnotatedItem
    */
   public boolean isAnnotationPresent(Class<? extends Annotation> annotationType)
   {
      return delegate().isAnnotationPresent(annotationType);
   }

   /**
    * @see org.jboss.webbeans.introspector.AnnotatedItem
    */
   public boolean isAssignableFrom(AnnotatedItem<?, ?> that)
   {
      return delegate().isAssignableFrom(that);
   }

   /**
    * @see org.jboss.webbeans.introspector.AnnotatedItem
    */
   public boolean isAssignableFrom(Set<Type> types)
   {
      return delegate().isAssignableFrom(types);
   }

   /**
    * @see org.jboss.webbeans.introspector.AnnotatedItem
    */
   public boolean isFinal()
   {
      return delegate().isFinal();
   }

   /**
    * @see org.jboss.webbeans.introspector.AnnotatedItem
    */
   public boolean isStatic()
   {
      return delegate().isStatic();
   }

   /**
    * @see org.jboss.webbeans.introspector.AnnotatedItem
    */
   public boolean isProxyable()
   {
      return delegate().isProxyable();
   }

   /**
    * Overridden method into delegate
    * 
    * @see org.jboss.webbeans.introspector.AnnotatedItem
    */
   @Override
   public boolean equals(Object obj)
   {
      return delegate().equals(obj);
   }

   /**
    * Overridden method into delegate
    * 
    * @see org.jboss.webbeans.introspector.AnnotatedItem
    */
   @Override
   public int hashCode()
   {
      return delegate().hashCode();
   }

   /**
    * Overridden method into delegate
    * 
    * @see org.jboss.webbeans.introspector.AnnotatedItem
    */
   @Override
   public String toString()
   {
      return delegate().toString();
   }
   
   public Set<Annotation> getDeclaredMetaAnnotations(Class<? extends Annotation> metaAnnotationType)
   {
      return delegate().getDeclaredMetaAnnotations(metaAnnotationType);
   }

   /**
    * Gets the annotated item
    * 
    * @return The annotated item
    */
   public abstract AnnotatedItem<T, S> delegate();

}
