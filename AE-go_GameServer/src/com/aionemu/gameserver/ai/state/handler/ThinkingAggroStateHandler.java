/*
 * This file is part of aion-unique <aion-unique.org>.
 *
 *  aion-unique is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  aion-unique is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with aion-unique.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aionemu.gameserver.ai.state.handler;

import com.aionemu.gameserver.ai.AI;
import com.aionemu.gameserver.ai.state.AIState;
import com.aionemu.gameserver.model.gameobjects.Npc;

/**
 * @author ATracer
 *
 */
public class ThinkingAggroStateHandler extends StateHandler
{

	@Override
	public AIState getState()
	{
		return AIState.THINKING;
	}

	/**
	 * State THINKING
	 * AI AggressiveMonsterAi
	 * AI GuardAi
	 */
	@Override
	public void handleState(AIState state, AI<?> ai)
	{
		ai.clearDesires();
		
		Npc owner = (Npc) ai.getOwner();
		
		if(owner.getAggroList().getMostHated() != null)
		{
			ai.setAiState(AIState.ATTACKING);
			return;
		}

		if(!owner.isAtSpawnLocation())
		{
			ai.setAiState(AIState.MOVINGTOHOME);
			return;
		}
		
		ai.setAiState(AIState.ACTIVE);
	}

}
