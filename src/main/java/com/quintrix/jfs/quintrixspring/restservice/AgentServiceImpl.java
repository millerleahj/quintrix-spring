package com.quintrix.jfs.quintrixspring.restservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.quintrix.jfs.quintrixspring.models.agent.Agents;

@Component
public class AgentServiceImpl implements AgentService {

  @Autowired
  RestTemplate restTemplate;



  @Value("${agentService.getUrl}")
  String agentServiceGetUrl;

  @Override
  public List<Agents> getAgentList() {
    List<Agents> agentsList = null;
    // String usersStr =
    // List<Agents> agentsList =
    ResponseEntity<List<Agents>> agentsListResponseEntity =
        // restTemplate.getForObject("https://gorest.co.in/public/v2/users", List.class);
        /*
         * should not hard code url's for ease of change; url is saved to application.yml
         */
        restTemplate.exchange(agentServiceGetUrl, HttpMethod.GET, null,
            new ParameterizedTypeReference<List<Agents>>() {});

    if (agentsListResponseEntity.getStatusCode() == HttpStatus.OK) {
      agentsList = agentsListResponseEntity.getBody();
      // getCarResponse.setAgentsList(agentsList);
    }

    return agentsList;

  }

  @Override
  public Agents getAgent(int id) {

    // List<Agents> agents = asList(restTemplate.getForObject(agentServiceGetUrl, Agents.class));

    // return agentsResponseEntity.getBody();


    ResponseEntity<List<Agents>> agentsListResponseEntity =
        restTemplate.exchange(agentServiceGetUrl, HttpMethod.GET, null,
            new ParameterizedTypeReference<List<Agents>>() {});
    List<Agents> agents = agentsListResponseEntity.getBody();

    return agents.get(id);
    // 0-19

  }
}
