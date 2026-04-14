
# Retail Inventory System

## Overview
This project is a Java-based retail simulation, analytics, and decision-support system.

It models an online retail environment where customers interact with products, generate transactions, and produce behavioural data.  
The system then analyses this data to extract insights, predict future trends, and detect abnormal behaviour.

The project evolves in phases from a basic transaction system into a full analytics and intelligence engine.

---

## Core Features (Phase 1)

- Product and inventory management
- Client management with purchase history tracking
- Sale transaction system (shopping basket model)
- File-based data loading with validation and cleaning
- Transaction simulation (random clients and purchases)
- Inventory updates based on sales
- Payment processing using reflection (CardPayment, EFTPayment)

---

## System Flow

Client → selects products → Sale created → Payment processed → Inventory updated → Purchase history stored

---

## Data Generated

The system generates structured data from simulations:

- Transaction data (sales, revenue, inventory changes)
- Client behaviour data (preferences, spending patterns)
- Product analytics (demand, co-purchases)
- Demographic data (age, nationality, segmentation)

---

## Analytics & Intelligence (Planned Features)

### 1. Client Behaviour Modelling
- Track favourite categories and brands
- Analyse purchase frequency and spending
- Build client profiles

---

### 2. Demographics & Segmentation
- Analyse customers by age groups and nationality
- Identify high-value customer segments
- Understand geographic distribution

---

### 3. Analytics Dashboard
- Total revenue and transaction summaries
- Top clients and top products
- Behaviour insights and trends

---

### 4. Recommendation Engine (Graph + BFS)
- Build product relationships based on co-purchases
- Suggest related products:
  - "Customers who bought this also bought..."

---

### 5. Fraud Detection (Rule-Based Anomaly Detection)
- Detect abnormal transactions based on behaviour
- Compare transaction against client baseline:
  - spending patterns
  - number of items
  - category consistency
- Block suspicious transactions

---

### 6. Revenue Forecasting (Predictive Analysis)
- Estimate future revenue using historical simulation data
- Apply:
  - average-based forecasting
  - trend analysis
- Identify future demand patterns

---

### 7. Product Clustering (Union-Find)
- Group related products into clusters
- Identify product ecosystems and bundles

---

### 8. Ranking & Sorting (TreeMap)
- Sort clients by spending
- Sort products by price and demand
- Generate ordered insights

---

## Algorithms & Data Structures

This system integrates multiple algorithmic approaches:

- Dynamic Programming → efficient total and metric tracking
- HashMaps → fast lookup and frequency counting
- Greedy Algorithms → top products and top clients
- Graph + BFS → recommendation system
- Union-Find → product clustering
- TreeMap (Balanced BST) → sorted analytics
- Rule-Based Heuristics → fraud detection
- Time Series Analysis → revenue forecasting

---

## Project Structure

```
Retail_Inventory_System/
├── src/
│   ├── Main.java
│   ├── Product.java
│   ├── Client.java
│   ├── Sale.java
│   ├── InventorySystem.java
│
├── clients.txt
├── products.txt
├── README.md
```


## Purpose

The goal of this project is to simulate a real-world retail system and progressively enhance it using data structures and algorithms to support:

- Behaviour analysis
- Decision making
- Risk detection
- Predictive insights

---

## Author

Masego Madisha
