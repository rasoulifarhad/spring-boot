package com.farhad.example.springdatajpa;

import java.io.Closeable;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ShutdownHooks {
    
    private final Set<Runnable> hooks = new HashSet<>();

    @PreDestroy
    private void onNodeShutdown() {
        log.info("Processing shutdown  hooks");
        boolean haveHooks = true;
        while (haveHooks) {
            final Runnable hook;
            synchronized (hooks) {
                hook = hooks.isEmpty() ? null : hooks.iterator().next();
                hooks.remove(hook);
                haveHooks = !hooks.isEmpty();
            }
            if (null != hooks) {
                try {
                    hook.run();
                } catch(RuntimeException ex) {
                    log.warn("failed tocall on shutdown hook for {}", hook, ex);
                }
            }
        }
        log.info("Finished processing shutdown hooks");
    }

    public Closeable addHook(final Runnable runnable) {
        synchronized (hooks) {
            hooks.add(runnable);
        }
        return () -> removeHook(runnable);
    }

    private void removeHook(final Runnable runnable) {
        synchronized (hooks) {
            hooks.remove(runnable);
        }
    }

}
