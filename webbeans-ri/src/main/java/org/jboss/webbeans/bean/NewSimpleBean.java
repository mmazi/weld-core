package org.jboss.webbeans.bean;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.webbeans.Dependent;
import javax.webbeans.Standard;

import org.jboss.webbeans.ManagerImpl;
import org.jboss.webbeans.MetaDataCache;
import org.jboss.webbeans.binding.NewBinding;
import org.jboss.webbeans.context.DependentContext;
import org.jboss.webbeans.introspector.AnnotatedField;
import org.jboss.webbeans.introspector.AnnotatedMethod;

public class NewSimpleBean<T> extends SimpleBean<T>
{
   private static Set<Annotation> NEW_BINDING_SET = new HashSet<Annotation>(Arrays.asList(new NewBinding()));

   public NewSimpleBean(Class<T> type, ManagerImpl manager)
   {
      super(type, manager);
   }

   @Override
   public T create()
   {
      try
      {
         DependentContext.INSTANCE.setActive(true);
         boolean passivating = MetaDataCache.instance().getScopeModel(getScopeType()).isPassivating();
         if (passivating)
         {
            checkProducedInjectionPoints();
         }
         T instance = getConstructor().newInstance(manager);
         bindDecorators();
         bindInterceptors();
         injectEjbAndCommonFields();
         injectBoundFields(instance, manager);
         callInitializers(instance);
         callPostConstruct(instance);
         return instance;
      }
      finally
      {
         DependentContext.INSTANCE.setActive(false);
      }
   }

   @Override
   public Class<? extends Annotation> getScopeType()
   {
      return Dependent.class;
   }

   @Override
   public Class<? extends Annotation> getDeploymentType()
   {
      return Standard.class;
   }

   @Override
   public String getName()
   {
      return null;
   }

   @Override
   public Set<AnnotatedMethod<Object>> getObserverMethods()
   {
      return Collections.emptySet();
   }

   @Override
   public Set<AnnotatedField<Object>> getProducerFields()
   {
      return Collections.emptySet();
   }

   @Override
   public Set<AnnotatedMethod<Object>> getProducerMethods()
   {
      return Collections.emptySet();
   }

   @Override
   public Set<Annotation> getBindingTypes()
   {
      return NEW_BINDING_SET;
   }

}