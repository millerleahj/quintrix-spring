package com.quintrix.jfs.quintrixspring.restservice;

import java.util.List;
import com.quintrix.jfs.quintrixspring.models.agent.Agents;

public interface AgentService {

  List<Agents> getAgentList();

  Agents getAgent(int id);

  List<Agents> availableAgents();

}
