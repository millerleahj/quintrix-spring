
package com.quintrix.jfs.quintrixspring.models.agent;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "agentsList"
})
@Generated("jsonschema2pojo")
public class SalesAgents {

    @JsonProperty("agentsList")
    private List<Agents> agentsList = null;

    @JsonProperty("agentsList")
    public List<Agents> getAgentsList() {
        return agentsList;
    }

    @JsonProperty("agentsList")
    public void setAgentsList(List<Agents> agentsList) {
        this.agentsList = agentsList;
    }

}
