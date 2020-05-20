package com.dehaat.dehaatassignment.presenter

abstract class BasePresenter {
    private var mDestroyed: Boolean = false

    fun start() { mDestroyed = false }

    fun stop() { mDestroyed = true }
}