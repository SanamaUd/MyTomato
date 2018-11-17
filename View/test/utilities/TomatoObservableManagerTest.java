package utilities;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TomatoObservableManagerTest {

	private static final TomatoObservation<Void> VOID_TYPE = new TomatoObservation<>();
	private static final TomatoObservation<Boolean> BOOLEAN_TYPE = new TomatoObservation<>();
	private TomatoObservableManager systemUnderTest;
	private Map<TomatoObservation<?>, List<TomatoActionListener<?>>> observers;
	private boolean flag;
	@Mock private TomatoActionListener<Void> voidListenerMock;
	@Mock private TomatoActionListener<Boolean> booleanListenerMock;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		flag = false;
		assertThat(flag, is(false));
		observers = new HashMap<>();
		systemUnderTest = new TomatoObservableManager(observers);
	}
	
	@Test
	public void shouldAddExpectedListeners() {
		assertThat(observers.size(), is(0));
		
		systemUnderTest.addObservers(VOID_TYPE, voidListenerMock);
		systemUnderTest.addObservers(VOID_TYPE, (unused)-> {flag = !flag; });
		assertThat(observers.size(), is(1));
		assertThat(observers.get(VOID_TYPE).size(), is(2));
		
		systemUnderTest.addObservers(BOOLEAN_TYPE, booleanListenerMock);
		assertThat(observers.size(), is(2));
		assertThat(observers.get(BOOLEAN_TYPE).size(), is(1));
	}
	
	@Test
	public void shouldCallThroughAllExpectedActionListenerWhenNotifying() {
		systemUnderTest.addObservers(VOID_TYPE, voidListenerMock);
		systemUnderTest.addObservers(VOID_TYPE, (unused)-> {flag = !flag; });
		systemUnderTest.addObservers(BOOLEAN_TYPE, booleanListenerMock);
		assertThat(flag, is(false));
		
		systemUnderTest.notifyObservers(VOID_TYPE, null);
		assertThat(flag, is(true));
		verify(voidListenerMock).update(null);
		verify(booleanListenerMock, never()).update(Mockito.anyBoolean());
	}
	
	@Test
	public void shouldRemoveExpectedListeners() {
		TomatoActionListener<Void> added = systemUnderTest.addObservers(VOID_TYPE, (unused)-> {flag = !flag; });
		TomatoActionListener<Void> addedB = systemUnderTest.addObservers(VOID_TYPE, voidListenerMock);
		assertThat(addedB, is(voidListenerMock));
		
		systemUnderTest.removeObservers(VOID_TYPE, added);
		assertThat(observers.get(VOID_TYPE).size(), is(1));
		assertThat(observers.get(VOID_TYPE), hasItem(voidListenerMock));
		
		systemUnderTest.removeObservers(VOID_TYPE, addedB);
		assertThat(observers.get(VOID_TYPE).size(), is(0));		
	}
}
