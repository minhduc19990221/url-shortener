# URL Shortener
## Integrated with Java Spring Boot and Redis

*Quickly shorten a http or https url into localhost domain and redirect shortened to original url*

**Technology stacks**
- Java SDK 19
- Spring Boot 4.3+
- Redis (using Jedis 4.3+)
- RedirectView
- The Simple Logging Facade for Java (SLF4J)

**Available API**
POST http://localhost:8080/shortener 
```
{
	"url": "https://medium.com/hackernoon/url-shortening-service-in-java-spring-boot-and-redis-d2a0f8848a1d"
}
```

GET http://localhost:8080/:id

### Development Phase

- [x] Initialize URL Shortener and core functionalities (validator, redirection, shortening, redis)
- [ ] Add authentication (JWT)
- [ ] Integrate CI/CD (Dockerize, AWS)
- [ ] Host a domain (nginx)
