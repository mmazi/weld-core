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
package org.jboss.webbeans.util.el;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.el.ValueExpression;

/**
 * @author pmuir
 *
 */
public abstract class ForwardingExpressionFactory extends ExpressionFactory
{

   protected abstract ExpressionFactory delegate();
   
   
   @SuppressWarnings("unchecked")
   @Override
   public Object coerceToType(Object obj, Class targetType)
   {
      return delegate().coerceToType(obj, targetType);
   }

   @SuppressWarnings("unchecked")
   @Override
   public MethodExpression createMethodExpression(ELContext context, String expression, Class expectedReturnType, Class[] expectedParamTypes)
   {
      return delegate().createMethodExpression(context, expression, expectedReturnType, expectedParamTypes);
   }

   @SuppressWarnings("unchecked")
   @Override
   public ValueExpression createValueExpression(Object instance, Class expectedType)
   {
      return delegate().createValueExpression(instance, expectedType);
   }

   @SuppressWarnings("unchecked")
   @Override
   public ValueExpression createValueExpression(ELContext context, String expression, Class expectedType)
   {
      return delegate().createValueExpression(context, expression, expectedType);
   }
   
   @Override
   public boolean equals(Object obj)
   {
      return delegate().equals(obj);
   }
   
   @Override
   public int hashCode()
   {
      return delegate().hashCode();
   }
   
   @Override
   public String toString()
   {
      return delegate().toString();
   }

}