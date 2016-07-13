import java.util.*;

public class Perceptron implements Neuron {
  private Map<Neuron, Connection> inputConnections;
  private Set<Neuron> outputConnections;

  public Perceptron(final Map<Neuron, Connection> inputs) {
    this.inputConnections = inputs;
  }

  public Double getActivation() {
    return inputConnections.entrySet()
                           .stream()
                           .mapToDouble(e -> e.getKey().getActivation() * e.getValue().getWeight() + e.getValue().getBias())
                           .sum();
  }
}
