/*
 * Copyright (C) 2022 - Amir Hossein Aghajari
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.aghajari.emojiview.twitterprovider;

import android.content.Context;

import com.aghajari.emojiview.R;
import com.aghajari.emojiview.emoji.Emoji;
import com.aghajari.emojiview.emoji.EmojiCategory;
import com.aghajari.emojiview.emoji.EmojiData;
import com.aghajari.emojiview.preset.AXPresetEmoji;
import com.aghajari.emojiview.preset.AXPresetEmojiCategory;
import com.aghajari.emojiview.preset.AXPresetEmojiProvider;

public final class AXTwitterEmojiProvider extends AXPresetEmojiProvider {

    public AXTwitterEmojiProvider(Context context) {
        super(context, new int[]{
                R.drawable.emoji_ios_category_people,
                R.drawable.emoji_ios_category_nature,
                R.drawable.emoji_ios_category_food,
                R.drawable.emoji_ios_category_activity,
                R.drawable.emoji_ios_category_travel,
                R.drawable.emoji_ios_category_objects,
                R.drawable.emoji_ios_category_symbols,
                R.drawable.emoji_ios_category_flags
        });
    }

    public AXTwitterEmojiProvider(Context context, int[] icons) {
        super(context, icons);
    }

    @Override
    public EmojiData getEmojiData() {
        return AXTwitterEmojiData.instance;
    }

    @Override
    protected EmojiCategory createCategory(int i, int icon) {
        return new AXTwitterEmojiCategory(i, icon, getEmojiData());
    }

    public static class AXTwitterEmojiCategory extends AXPresetEmojiCategory {
        public AXTwitterEmojiCategory(int i, int icon, EmojiData emojiData) {
            super(i, icon, emojiData);
        }

        @Override
        protected Emoji createEmoji(String code, int category, int index, EmojiData emojiData){
            return new AXTwitterEmoji(code, emojiData);
        }
    }

    public static class AXTwitterEmoji extends AXPresetEmoji {
        public AXTwitterEmoji(String code, EmojiData emojiData) {
            super(code, emojiData);
        }
    }
}

