package timermodel;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import utilities.TomatoActionListener;

public class TimerModelTest {

	private static final int EXPECTED_INITIAL_VALUE_IN_SECONDS = 25*60;
	private TimerModel systemUnderTest;
	@Mock private TomatoActionListener<Duration> durationListenerMock;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	   systemUnderTest = new TimerModel();
	}
	
	@Test
	public void shouldDecrementByExpectedDurationWhenFiringSecondElapsedEvent() {
		assertThat(systemUnderTest.getDuration(), is(TimerModel.INITIAL_DURATION));
		
		assertThat(systemUnderTest.getDuration(), is(Duration.ofSeconds(EXPECTED_INITIAL_VALUE_IN_SECONDS)));		
		systemUnderTest.fireSecondElapsedEvent();	    
		assertThat(systemUnderTest.getDuration(), is(Duration.ofSeconds(EXPECTED_INITIAL_VALUE_IN_SECONDS - 1)));
	}
	
	@Test
	public void shouldNotifyExpectedObserversWhenFiringSecondElapsedEvent() {
		systemUnderTest.getObservableManager().addObservers(TimerModel.DURATION_MODIFIED, durationListenerMock);
		
		systemUnderTest.fireSecondElapsedEvent();
		Mockito.verify(durationListenerMock).update(Duration.ofSeconds(EXPECTED_INITIAL_VALUE_IN_SECONDS - 1));
	}
}
