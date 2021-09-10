import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class TestReactive {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestReactive.class);

    @Test
    public void test() {


        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(2);
        integerArrayList.add(3);
        integerArrayList.add(4);

        Scheduler scheduler = Schedulers.newParallel("parallel-scheduler", 4);
        Flux<Integer> seq2 = Flux.fromIterable(integerArrayList);
          seq2.map(x -> x+1).publishOn(scheduler) .subscribe(x -> {
                            System.out.println(x);
                            LOGGER.info("" + x);
                        },
                        e -> {
                            System.out.println(e);

                        },
                        () -> {
                            System.out.println("complet");
                            LOGGER.info("complet");
                        });
    }



    @Test
    public void test3() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(2);
        integerArrayList.add(3);
        integerArrayList.add(4);
        Flux<Integer> publisher = Flux.fromIterable(integerArrayList);
        publisher.subscribe(new ArraySubscriber());



    }
    @Test
    public void test4() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(2);
        integerArrayList.add(3);
        integerArrayList.add(4);

        Flux<Integer> seq2 = Flux.fromIterable(integerArrayList);
        seq2.map(x -> x + 1).map(x -> x * 2)
                .subscribe(x -> {
                            System.out.println(x);
                            LOGGER.info("" + x);
                        },
                        e -> {
                            System.out.println(e);

                        },
                        () -> {
                            System.out.println("complet");
                            LOGGER.info("complet");
                        });


    }


    public class ArraySubscriber implements Subscriber<Integer> {


        @Override
        public void onNext(Integer integer) {
            LOGGER.info("evebment recu"+ integer);
            System.out.println("evebment recu"+ integer);
        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onComplete() {
            LOGGER.info("flux d evenement termine");
            System.out.println("flux d evenement termine");
        }

        @Override
        public void onSubscribe(Subscription subscription) {

        }
    }


}

