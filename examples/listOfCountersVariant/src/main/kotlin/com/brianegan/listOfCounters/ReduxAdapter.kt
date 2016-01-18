package com.brianegan.listOfCounters

import com.github.andrewoma.dexx.kollection.immutableListOf
import trikita.anvil.RenderableAdapter

class ReduxAdapter<M, VM>(val mapModelToViewModel: (M) -> VM, val r: RenderableAdapter.Item<VM>) : RenderableAdapter() {
    var models: List<M> = immutableListOf()

    override fun getCount(): Int {
        return models.size
    }

    override fun getItem(position: Int): VM {
        return mapModelToViewModel(models[position])
    }

    override fun view(pos: Int) {
        r.view(pos, this.getItem(pos));
    }

    fun update(newModels: List<M>): ReduxAdapter<M, VM> {
        if (models.equals(newModels).not()) {
            this.models = newModels;
            notifyDataSetChanged()
        }

        return this
    }
}
