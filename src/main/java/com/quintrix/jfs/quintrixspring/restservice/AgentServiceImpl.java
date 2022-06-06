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
  public List<Agents> availableAgents() {
    List<Agents> activeAgents = null;
    ResponseEntity<List<Agents>> agentsList = restTemplate.exchange(agentServiceGetUrl,
        HttpMethod.GET, null, new ParameterizedTypeReference<List<Agents>>() {});

    List<Agents> agents = agentsList.getBody();

    if (agentsList.getStatusCode() == HttpStatus.OK) {

      // Agents active = agents.stream().filter(x -> x.getStatus().equals("active")).findAny();
      // activeAgents.add(active);
    }
    return null;
  }

  @Override
  public Agents getAgent(int id) {

    ResponseEntity<List<Agents>> agentsList = restTemplate.exchange(agentServiceGetUrl,
        HttpMethod.GET, null, new ParameterizedTypeReference<List<Agents>>() {});

    // Agents getAgents = restTemplate.getForObject(agentServiceGetUrl, Agents.class, null);
    // ResponseEntity<Agents> getAgents = restTemplate.getForEntity(agentServiceGetUrl,
    // Agents.class);
    // return getAgents.getBody();

    // ResponseEntity<Agents> getAgents = restTemplate
    // .exchange("https://gorest.co.in/public/v2/users/4", HttpMethod.GET, null, Agents.class);

    ResponseEntity<Agents> getAgents =
        restTemplate.exchange(agentServiceGetUrl + "/" + id, HttpMethod.GET, null, Agents.class);

    return getAgents.getBody();



    // if (agentsList != null) {
    // Optional<Agents> agent;
    // // agent = agentRepository.findById(4044);
    // return agent;
    // }

    // return null;

    // ResponseEntity<Optional<Agents>> agentsById = restTemplate.exchange(agentServiceGetUrl,
    // HttpMethod.GET, null, new ParameterizedTypeReference<Optional<Agents>>() {});

    // exchange.string, http method, http entity,

    // agent = agent.getBody();

    // Work around
    // List<Agents> agentsList = getAgentList();
    // Optional<Agents> agent = agentsList.stream().filter(x -> x.getId().equals(id)).findAny();

    // return agent.get();

    // Work in progress: --no longer needed

    // List<Agents> agents = asList(restTemplate.getForObject(agentServiceGetUrl, Agents.class));
    // return agentsResponseEntity.getBody();

    // List<Agents> agents = agentsListResponseEntity.getBody();


    // return agents.get(id);
    // 0-19

  }
}
