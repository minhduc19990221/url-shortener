# :earth_asia: URL Shortener :earth_asia: 
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
	"url": "https://anything.com/you-can-include-its-id"
}
```

GET http://localhost:8080/:id

### Development Phase

- [x] Initialize URL Shortener and core functionalities (validator, redirection, shortening, redis) :minibus:
- [ ] Add authentication (JWT) :closed_lock_with_key:
- [ ] Integrate CI/CD (Dockerize, AWS) :whale:
- [ ] Host a domain (nginx) :computer:
