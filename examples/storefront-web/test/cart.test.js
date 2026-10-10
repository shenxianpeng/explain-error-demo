import assert from 'node:assert/strict';
import test from 'node:test';
import dayjs from 'dayjs';
import { summarise } from '../src/cart.js';

test('adds up line items', () => {
  const { total } = summarise([{ price: 19.99, quantity: 2 }, { price: 5, quantity: 1 }], dayjs('2026-01-01'));
  assert.equal(total, '$44.98');
});
