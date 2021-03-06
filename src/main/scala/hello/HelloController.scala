package hello

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.concurrent.atomic.AtomicLong
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.http.HttpMethod

@RestController
class HelloController {
  private final val template: String = "Hello, %s!";
  private final val counter: AtomicLong = new AtomicLong();
    @RequestMapping(value = Array("/"), method = Array(RequestMethod.GET))
  def greetings(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting = {
    return new Greeting(counter.incrementAndGet(),
      String.format(template, name));
  }
}
