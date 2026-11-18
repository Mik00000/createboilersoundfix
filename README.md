# Create Boiler Sound Fix

A lightweight performance optimization and bugfix mod for **Create** on Minecraft 1.21.1 (NeoForge).

---

## 🔍 The Problem

In large Create factories with multiple active steam boilers, Create's `SoundPool` queues hundreds of sound position checks per tick. This leads to:
1. Deafening, repetitive sound stacking (candles, steam fizzle).
2. Heavy CPU overhead (5–12% of total client tick time) spent in `SoundPool.rollNextPosition` and audio raytracing.

---

## ⚡ The Solution

`Create Boiler Sound Fix` injects a clean Mixin into `com.simibubi.create.content.fluids.tank.SoundPool`:
- Flushes `queuedPositions` in $O(1)$.
- Cancels unnecessary audio raytracing loops, eliminating lag spikes and sound stacking without affecting standard gameplay sounds.

---

## 📦 Compatibility

- **Minecraft:** `1.21.1`
- **NeoForge:** `21.1.x`
- **Create:** `6.0.x`
- Client & Server safe (can be installed on client-only or both).

---

## 📄 License

This mod is licensed under the **MIT License**.
