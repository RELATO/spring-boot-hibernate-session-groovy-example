# spring-boot-hibernate-example

This project demonstrates how to use spring beans with hibernate session, hql, Criteria, etc

The beauty is:

@Transactional annotation instead of

```
    Transaction tx = null;
    try {
      
      tx = session.beginTransaction();
      session.flush();
      tx.commit();
    } catch (HibernateException he) {
      if(tx != null){
        tx.rollback();
      } 
      throw new HibernateException(he);
    }
```

Source:
http://www.devglan.com/spring-boot/spring-boot-hibernate-5-example

## Several demos
https://github.com/roncoo/spring-boot-demo

## Compiling for web
mvn -Pweb package

## Compiling for console
mvn -Pconsole package

## Running 
java -jar target/spring-boot-hibernate-example-0.0.jar

## Tips on using different profiles 
https://stackoverflow.com/questions/25420745/how-to-set-spring-active-profiles-with-maven-profiles?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa

## Scripting
https://github.com/appcoreopc/app/tree/master/appCore.Scripting

e

https://github.com/zjlwmz/jeewx/tree/0d142675e938b4baebd11179a2914412ae23f6f1/src/main/java/cn/emay/framework/core/groovy

## Resources in spring
http://zetcode.com/articles/springbootloadres/
