"""Stock levels for the warehouse, and the call that refreshes them."""

import requests

SUPPLIER_API = "https://supplier.acme.dev/api/v2/stock"


class OutOfStock(Exception):
    """Raised when an order asks for more units than the shelf holds."""


class Stock:
    def __init__(self, levels=None):
        self._levels = dict(levels or {})

    def available(self, sku):
        return self._levels.get(sku, 0)

    def reserve(self, sku, quantity):
        if quantity > self.available(sku):
            raise OutOfStock(f"{sku}: wanted {quantity}, have {self.available(sku)}")
        self._levels[sku] -= quantity
        return self._levels[sku]

    def refresh(self, session=None):
        """Pull the latest levels from the supplier."""
        response = (session or requests).get(SUPPLIER_API, timeout=10)
        response.raise_for_status()
        self._levels.update(response.json())
        return len(self._levels)
