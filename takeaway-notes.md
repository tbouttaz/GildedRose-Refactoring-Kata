# [GuildedRose](https://github.com/emilybache/GildedRose-Refactoring-Kata)

## Refactoring Techniques
### Slow Scroll
Identify IDE suggestions (F2 to jump to next)

### Bumpy Road smell
Lots of indentation, making hard to follow overall intent
Solution: Use IDE's Code Folding to collapse complexity, then expend and try to address one level at a time

### Feature Envy code smell
Highlight `item` variable → IDE shows used in many places → suggests that code belong in the `Item` class instead
1. Extract Method 
2. Move to Item class 
3. Convert to Instance Method
 
### Lif up Ifs
Code smell: Repeated ifs (checking same condition in different branches):
1. Extract condition to `isBool` var
2. Extract code using `isBool` to `temp()` method
3. Introduce `if(isBool) temp(true) else temp(false)`
4. Inline `temp()`