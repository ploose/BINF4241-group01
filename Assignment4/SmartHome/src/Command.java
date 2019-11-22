public interface Command {
    String toString();
    String[] getOptions();
    String[] execute(String decision);
    boolean isActive();
}