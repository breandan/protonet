public class Connection {
  public double getWeight() {
    return weight;
  }

  public double getBias() {
    return bias;
  }

  private Neuron neighbor;
  private double weight, bias;

  public Connection(final Neuron neighbor, final double weight, final double bias) {
    this.neighbor = neighbor;
    this.weight = weight;
    this.bias = bias;
  }

  public Neuron getNeighbor() {
    return neighbor;
  }
}
