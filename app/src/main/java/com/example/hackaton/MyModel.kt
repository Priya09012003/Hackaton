package com.example.hackaton

abstract class MyModel(val backgroundResId: Int, val value: String) {
    abstract val itemType: Any

    companion object {
        const val SELECTED_ITEM = 0
        const val AVAILABLE_ITEM = 1
        const val NOT_AVAILABLE_ITEM = 2
    }
}

