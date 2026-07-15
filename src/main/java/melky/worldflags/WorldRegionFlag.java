/*
 * Copyright (c) 2020, melky <https://github.com/melkypie>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package melky.worldflags;

import com.google.common.collect.ImmutableMap;
import java.awt.image.BufferedImage;
import java.util.Map;
import net.runelite.client.util.ImageUtil;
import net.runelite.http.api.worlds.WorldRegion;

enum WorldRegionFlag
{
	// Follow ISO 3166-1 alpha-2 for country codes
	FLAG_US(WorldRegion.UNITED_STATES_OF_AMERICA),
	FLAG_GB(WorldRegion.UNITED_KINGDOM),
	FLAG_AU(WorldRegion.AUSTRALIA),
	FLAG_BR(WorldRegion.BRAZIL),
	FLAG_DE(WorldRegion.GERMANY),
	FLAG_JP(WorldRegion.JAPAN),
	FLAG_SG(WorldRegion.SINGAPORE),
	FLAG_ZA(WorldRegion.SOUTH_AFRICA);

	private static final Map<WorldRegion, WorldRegionFlag> worldRegionMap;

	private final WorldRegion region;

	static
	{
		ImmutableMap.Builder<WorldRegion, WorldRegionFlag> builder = new ImmutableMap.Builder<>();

		for (final WorldRegionFlag worldRegion : values())
		{
			builder.put(worldRegion.region, worldRegion);
		}
		worldRegionMap = builder.build();
	}

	WorldRegionFlag(WorldRegion region)
	{
		this.region = region;
	}

	BufferedImage loadImage()
	{
		final String resourceName = "/" + this.name().toLowerCase() + ".png";
		// Load resources from the root of classpath
		return ImageUtil.loadImageResource(WorldRegionFlag.class, resourceName);
	}

	static WorldRegionFlag getByRegion(WorldRegion region)
	{
		return worldRegionMap.get(region);
	}
}
