package com.quintrix.jfs.quintrixspring.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;
import com.quintrix.jfs.quintrixspring.models.agent.Agents;
import com.quintrix.jfs.quintrixspring.restservice.AgentServiceImpl;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringTestConfig.class)
public class AgentsRestTest {

  @Value("${agentService.getUrl}")
  String agentServiceGetUrl;

  @Mock
  private RestTemplate restTemplate;

  @InjectMocks
  private AgentServiceImpl agentsServ = new AgentServiceImpl();

  @Test
  void restMockitoTest() {

    Agents agent = new Agents(555, "Test Name", "testemail@email.com", "gender", "status");

    Mockito.when(restTemplate.getForEntity(agentServiceGetUrl, Agents.class))
        .thenReturn(new ResponseEntity(agent, HttpStatus.OK));


    Agents agentTest = agentsServ.getAgent(555);
    Assertions.assertEquals(agent, agentTest);
  }

  @Test
  void restSpringTest() {

  }

}
