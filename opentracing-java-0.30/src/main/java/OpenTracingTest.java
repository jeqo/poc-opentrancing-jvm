/**
 *
 */
public class OpenTracingTest {

  private static void waitABit() {
    try {
      Thread.sleep((long) (Math.random() * 1000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws InterruptedException {
//    final Tracer mainProcessTracer =
//        TracerFactory.getInstance(TracerFactory.Provider.JAEGER, "Main Process");
    final MainProcess mainProcess = new MainProcess();
    mainProcess.mainTask();

//    final Tracer otherProcessTracer =
//        TracerFactory.getInstance(TracerFactory.Provider.JAEGER, "Another Process");
    final OtherProcess otherProcess = new OtherProcess();
    otherProcess.anotherTask();

    //Shutdown process
    Thread.sleep(2000);
  }
  ////////////

  ////////////////////
  // Node 1 Process //
  ////////////////////
  static class MainProcess {
//    private final Tracer tracer;
//
//    MainProcess(Tracer tracer) {
//      this.tracer = tracer;
//    }

    void mainTask() {
      waitABit();

      childTask();
    }

    private void childTask() {
      waitABit();
    }
  }

  ////////////////////
  // Node 2 Process //
  ////////////////////
  static class OtherProcess {
//    private final Tracer tracer;
//
//    OtherProcess(Tracer tracer) {
//      this.tracer = tracer;
//    }

    void anotherTask() {
      waitABit();
    }
  }
}
