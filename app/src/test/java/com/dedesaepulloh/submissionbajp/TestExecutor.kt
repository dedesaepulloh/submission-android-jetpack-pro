package com.dedesaepulloh.submissionbajp

import java.util.concurrent.Executor

class TestExecutor: Executor {
    override fun execute(p0: Runnable) {
        p0.run()
    }
}