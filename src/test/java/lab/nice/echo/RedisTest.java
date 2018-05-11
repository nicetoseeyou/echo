package lab.nice.echo;


import junit.framework.TestCase;
import lab.nice.echo.model.User;
import lab.nice.echo.repository.*;
import lab.nice.echo.service.impl.PostIDService;
import lab.nice.echo.service.impl.TimelineIDService;
import lab.nice.echo.service.impl.UserIDService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:application-config.xml", "classpath:spring-mvc-config.xml"})
@WebAppConfiguration
public class RedisTest extends TestCase {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserIDService userIDService;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostIDService postIDService;
    @Autowired
    private TimelineRepository timelineRepository;
    @Autowired
    private TimelineIDService timelineIDService;
    @Autowired
    private FollowersRepository followersRepository;
    @Autowired
    private FollowingRepository followingRepository;

    @Test
    public void testUserCrud(){
        final Long uid = userIDService.nextID();
        User user = new User("test-user-01");
        user.setUid(uid);
        //create
        userRepository.save(user);
        assertTrue("Create user failed", userRepository.existsById(uid));
        //update
        String newName = "test-user-01-new";
        user.setName(newName);
        userRepository.save(user);
        assertTrue("Update user failed", userRepository.findById(uid).get().getName().equals(newName));
        //delete
        userRepository.deleteById(uid);
        assertFalse("Delete user failed", userRepository.existsById(uid));
    }
}
