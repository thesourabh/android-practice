package course.labs.intentslab.test;

import course.labs.intentslab.ActivityLoaderActivity;
import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;

public class ImplicitTest extends
		ActivityInstrumentationTestCase2<ActivityLoaderActivity> {
	private Solo solo;

	public ImplicitTest() {
		super(ActivityLoaderActivity.class);
	}

	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation());
		getActivity();
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

	public void testRun() {

		int timeout = 5;

		// Wait for activity: 'course.labs.intentslab.ActivityLoaderActivity'
		assertTrue(
				"course.labs.intentslab.ActivityLoaderActivity is not found!",
				solo.waitForActivity(course.labs.intentslab.ActivityLoaderActivity.class));

		// Click on Implicit Activation
		solo.clickOnView(solo
				.getView(course.labs.intentslab.R.id.implicit_activation_button));


		// Wait for activity: 'com.android.internal.app.ChooserActivity'
		assertTrue("ChooserActivity is not found!",
				solo.waitForActivity("ChooserActivity"));

		// Click on MyBrowser
		solo.clickInList(2, 0);

	}
}
