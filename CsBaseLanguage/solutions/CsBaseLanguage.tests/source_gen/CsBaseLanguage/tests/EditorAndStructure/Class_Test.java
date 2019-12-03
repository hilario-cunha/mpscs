package CsBaseLanguage.tests.EditorAndStructure;

/*Generated by MPS */

import jetbrains.mps.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.ClassRule;
import jetbrains.mps.lang.test.runtime.TestParametersCache;
import org.junit.Rule;
import jetbrains.mps.lang.test.runtime.RunWithCommand;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.lang.test.runtime.TransformationTest;

@MPSLaunch
public class Class_Test extends BaseTransformationTest {
  @ClassRule
  public static final TestParametersCache ourParamCache = new TestParametersCache(Class_Test.class, "${project_home}", "r:fcdf8a98-8638-4be9-822b-7c6b6a82fdf7(CsBaseLanguage.tests.EditorAndStructure@tests)", false);
  @Rule
  public final RunWithCommand myWithCommandRule = new RunWithCommand(this);

  public Class_Test() {
    super(ourParamCache);
  }

  @Test
  public void test_dummyTestMethod() throws Throwable {
    new TestBody(this).test_dummyTestMethod();
  }

  /*package*/ static class TestBody extends BaseTestBody {

    /*package*/ TestBody(TransformationTest owner) {
      super(owner);
    }

    public void test_dummyTestMethod() throws Exception {
      addNodeById("5848411784120487986");
      assert true;
    }


  }
}