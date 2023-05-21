package rpc.controller.view.models.params;

import java.util.List;
import java.util.Set;

public class ParamModel {
    /**
     * prompts Set
     */
    private Set<List<String>> stdPromts;

    public Set<List<String>> getStdPromts() {
        return stdPromts;
    }

    public void setStdPromts(Set<List<String>> stdPromts) {
        this.stdPromts = stdPromts;
    }
}
