package io.commitr.goal;

import io.commitr.util.DTOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Created by Peter Douglas on 9/6/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GoalServiceTest {

    @Mock
    Goal goalMock;

    @MockBean
    private GoalRepository goalRepository;

    @Autowired
    private GoalService goalService;

    @Test
    public void createGoal() throws Exception {
        given(this.goalRepository.save(goalMock))
                .willReturn(Goal.of(DTOUtils.VALID_UUID, "Test Goal", DTOUtils.VALID_UUID));

        Goal goal = goalService.createGoal(goalMock);

        assertThat(goal.getUuid()).isNotNull();
        assertThat(goal.getUuid()).isEqualTo(DTOUtils.VALID_UUID);
        assertThat(goal.getTitle()).isEqualTo("Test Goal");
    }

    @Test
    public void getGoal() throws Exception {
        given(this.goalRepository.findByUuid(DTOUtils.VALID_UUID))
                .willReturn(Goal.of(DTOUtils.VALID_UUID, "Test Goal", DTOUtils.VALID_UUID));

        Goal goal = goalService.getGoal(DTOUtils.VALID_UUID);

        assertThat(goal.getUuid()).isNotNull();
        assertThat(goal.getUuid()).isEqualTo(DTOUtils.VALID_UUID);
        assertThat(goal.getTitle()).isEqualTo("Test Goal");
    }

    @Configuration
    static class ServiceConfig {
        @Mock
        GoalRepository repository;

        @Primary
        @Bean
        public GoalRepository goalRepository() {
            return repository;
        }

        @Bean
        public GoalService goalService() {
            return new GoalServiceImpl();
        }
    }

}