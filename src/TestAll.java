import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestPayStation.class,
	TestUnitLinearRateStrategy.class,
	TestUnitProgressiveRateStrategy.class,
	TestUnitUsPaymentStrategy.class,
	TestUnitDanishPaymentStrategy.class,
	TestIntegration.class })
public class TestAll {
}

/**
 Our lizard has evolved. Meet Martin, Martin the lizard. 
 
                    _.....---..._
     _..-'-.   _.--'             '--.._
 _.-' (  0) Y''                        ''-.._
(---.._,                                     '-._
 `---.,___.-\  \----......./  /..------...____   '-.
    _/  /  _/  /         __\  \   __\  \      `-.   \
   (((-'  (((-'         (((---'  (((---`         )  /
                                              .-'.-'
                                             (__`-,
                                                ``
*/