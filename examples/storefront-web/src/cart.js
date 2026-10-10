import dayjs from 'dayjs';
import currency from 'currency.js';

/** Total of a cart, and when its reservation runs out. */
export function summarise(items, now = dayjs()) {
  const total = items.reduce((sum, item) => sum.add(currency(item.price).multiply(item.quantity)), currency(0));
  return { total: total.format(), expires: now.add(15, 'minute').toISOString() };
}
